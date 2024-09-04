#Login Activity(Kotlin)
De que trara esta app?
esta app es un login basico, con las caracteristicas que al momento de entrar vemos una app normal, que consta de 3 fases.

Login
aca tenemos un login basico, programado con un base de datos SQLite, donde el usuario puede iniciar sesion con su contraseña y automaticamente le valida su contraseña.

Register
Donde hay un Login tiene que ver un registro donde el usuario puede entrar y llenar sus datos de usuario, contraseña, confirmar contraseña.
todod eso llevandolo a la base de datos antes mecionada, automaticamente validando y llevandolo al menu.

Menu
aca podemos observar una recyclerview, donde el usuario puede ver unas cardView con datos de donas, en el cual puede interactuar.


###Dependencias usadas en la app:

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
        implementation("androidx.recyclerview:recyclerview:1.2.1")
        implementation("androidx.cardview:cardview:1.0.0")
        implementation ("com.google.android.material:material:1.5.0")
        implementation ("androidx.coordinatorlayout:coordinatorlayout:1.1.0")

