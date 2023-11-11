<h1>Shopping Jetminds - Persian Version</h1>
<h2>Shopping app which connects to Woocommerce and wordpress REST API</h2>
<p>Shopping Jetminds is an android shopping app wich connects to Woocommerce and Wordpress api as back-end service.
    It uses the Retrofit and OkHttp3 to get and put data to web api and also uses Room Database to store and cache the data in database.
    Just change some urls and keys to use it on your Wordpress shopping website. :))
</p>
<br>
<h2>Screenshots</h2>
<br>
<h2>App screens</h2>
<ul>
    <li><b>Splash Screen:</b> App splash screen</li>
    <li><b>Onboarding Screens:</b> App welcome and introduction screens</li>
    <li><b>Login and Register:</b> Sign in and Sign up throught Wordpress Api</li>
    <li><b>Home:</b> Main screen to show some carousel of products</li>
    <li><b>Shop:</b> Shop screen to show all products and also searching, sorting and filter products</li>
    <li><b>Product Details:</b> Product details screen which shows the details of a product. Also it shows product Description, Features and comments</li>
    <li><b>Categories:</b> Shows the products categories.</li>
    <li><b>Cart:</b> Cart screen</li>
    <li><b>Checkout:</b> Checkout screen</li>
    <li><b>Favorites:</b> Favorite screen for your favorite products</li>
    <li><b>Search:</b> Search screen to searching in products.</li>
    <li><b>Downloads:</b> For user downloaded products (in progress ...)</li>
    <li><b>Notifications:</b> User notifications. (in progress ...)</li>
    <li><b>Profile:</b> User profile screen from Woocommerce REST API (customer role in wordpress - in progress ...)</li>
    <li><b>Coupons:</b> All coupons that defined in Wordpress your site (in progress ...)</li>
    <li><b>Compare:</b> Compare screen for comparing products. (in progress ...)</li>
    <li><b>Orders:</b> User orders history screen (in progress ...)</li>
    <li><b>Settings:</b> App settings (in progress ...)</li>
    <li><b>About us:</b> About us screen (in progress ...)</li>
</ul>
<br>
<h2>Techs</h2>
<ul>
    <li>Jetpack Compose</li>
    <li>Kotlin Coroutines</li>
    <li>Kotlin Flow</li>
    <li>Dagger Hilt</li>
    <li>Retrofit2</li>
    <li>Room Database</li>
    <li>MVVM Architecture</li>
    <li>Clean Architecture</li>
    <li>Multi Module</li>
    <li>Navigation Compose</li>
    <li>Material3</li>
    <li>ViewModel</li>
    <li>DataStore</li>
    <li>Gson Converters</li>
    <li>Accompanist</li>
</ul>
<br>
<h2>Setup</h2>
<p>In local.properties add your wordpress consumer key and consumer secret.</p>
<p>CONSUMER_KEY="YOUR CONSUMER KEY HERE"</p>
<p>CONSUMER_SECRET="YOUR CONSUMER SECRET HERE"</p>
<br>
<p>In data module -> network module -> utils folder, in Constants and WordpressConstants file change the urls to your website url. like this:</p>
<p>In Constans: const val BASE_URL = "https://your-website-url.com/wp-json/wc/v3/"</p>
<p>In WordpressConstants: const val WORDPRESS_BASE_URL = "https://your-website-url.com/wp-json/wp/v2/"</p>
<p>In WordpressConstants: const val TOKEN_BASE_URL = "https://your-website-url.com/wp-json/api/v1/"</p>
<p>Notice: You need install miniOrange api authentication plugin to generate jwt token to allow you to access wordpress protected urls like users, posts and ...</p>
