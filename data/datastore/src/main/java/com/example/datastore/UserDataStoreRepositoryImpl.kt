/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/5/23, 9:06 AM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.data_store.UserDataStoreRepository
import com.example.domain.models.user.UserCredentials
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_prefs")

class UserDataStoreRepositoryImpl @Inject constructor(
    @ApplicationContext context: Context
): UserDataStoreRepository {

    private object UserPreferencesKeys {
        val username = stringPreferencesKey(name = "user_username")
        val password = stringPreferencesKey(name = "user_password")
        val token = stringPreferencesKey(name = "user_token")
    }

    private val dataStore = context.dataStore

    override suspend fun saveUserCredentials(userCredentials: UserCredentials) {
        dataStore.edit { preferences ->
            preferences[UserPreferencesKeys.username] = userCredentials.username
            preferences[UserPreferencesKeys.password] = userCredentials.password
        }
    }

    override fun readUserCredentials(): Flow<UserCredentials> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val username = preferences[UserPreferencesKeys.username] ?: ""
                val password = preferences[UserPreferencesKeys.password] ?: ""
                val userCredentials = UserCredentials(username = username, password = password)
                userCredentials
            }
    }

    override suspend fun saveUserToken(token: String) {
        dataStore.edit { preferences ->
            preferences[UserPreferencesKeys.token] = token
        }
    }

    override fun readUserToken(): Flow<String> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val token = preferences[UserPreferencesKeys.token] ?: ""
                token
            }
    }
}