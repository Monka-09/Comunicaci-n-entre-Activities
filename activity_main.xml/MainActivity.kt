// activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/formLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:visibility="visible">

        <EditText
            android:id="@+id/etNombre"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:hint="Ingresa tú nombre"
            android:layout_marginTop="200dp"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintWidth_percent="0.8" />

        <EditText
            android:id="@+id/etEdad"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:inputType="number"
            android:hint="Ingresa tú edad"
            android:layout_marginTop="50dp"
            app:layout_constraintTop_toBottomOf="@id/etNombre"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintWidth_percent="0.8" />

        <Button
            android:id="@+id/btnEnviar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="50dp"
            android:onClick="enviarDatos"
            android:text="Enviar"
            android:background="#3A038C"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.501"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@id/etEdad"
            />
    </androidx.constraintlayout.widget.ConstraintLayout>


    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/mainLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:visibility="gone">

        <TextView
            android:id="@+id/tvNombre"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Nombre"
            android:textSize="24sp"
            android:textStyle="bold"
            android:layout_marginTop="16dp"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent" />

        <TextView
            android:id="@+id/tvEdad"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Edad"
            android:textSize="24sp"
            android:layout_marginTop="16dp"
            app:layout_constraintTop_toBottomOf="@id/tvNombre"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent" />

        <Button
            android:id="@+id/btnRegresar"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Regresar al Formulario"
            android:layout_marginTop="32dp"
            app:layout_constraintTop_toBottomOf="@id/tvEdad"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            android:onClick="regresarFormulario" />

</androidx.constraintlayout.widget.ConstraintLayout>
-----------------------------------------------------------------------------------------------------------------------
//MainActivity.kt
package com.example.comunicacinentreactivities

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var tvNombre: TextView
    private lateinit var tvEdad: TextView
    private lateinit var formLayout: View
    private lateinit var mainLayout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etNombre = findViewById(R.id.etNombre)
        etEdad = findViewById(R.id.etEdad)
        formLayout = findViewById(R.id.formLayout)


        tvNombre = findViewById(R.id.tvNombre)
        tvEdad = findViewById(R.id.tvEdad)
        mainLayout = findViewById(R.id.mainLayout)
    }


    fun enviarDatos(view: View) {
        val nombre = etNombre.text.toString()
        val edad = etEdad.text.toString()


        tvNombre.text = "Nombre: $nombre"
        tvEdad.text = "Edad: $edad"


        val fadeOut = AlphaAnimation(1.0f, 0.0f)
        fadeOut.duration = 500
        fadeOut.fillAfter = true


        val fadeIn = AlphaAnimation(0.0f, 1.0f)
        fadeIn.duration = 500
        fadeIn.fillAfter = true


        fadeOut.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationStart(animation: android.view.animation.Animation?) {}
            override fun onAnimationRepeat(animation: android.view.animation.Animation?) {}
            override fun onAnimationEnd(animation: android.view.animation.Animation?) {
                formLayout.visibility = View.GONE
                mainLayout.visibility = View.VISIBLE
                mainLayout.startAnimation(fadeIn)
            }
        })


        formLayout.startAnimation(fadeOut)
    }


    fun regresarFormulario(view: View) {


        val fadeOut = AlphaAnimation(1.0f, 0.0f)
        fadeOut.duration = 500
        fadeOut.fillAfter = true


        val fadeIn = AlphaAnimation(0.0f, 1.0f)
        fadeIn.duration = 500
        fadeIn.fillAfter = true


        fadeOut.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationStart(animation: android.view.animation.Animation?) {}
            override fun onAnimationRepeat(animation: android.view.animation.Animation?) {}
            override fun onAnimationEnd(animation: android.view.animation.Animation?) {
                mainLayout.visibility = View.GONE
                formLayout.visibility = View.VISIBLE
                formLayout.startAnimation(fadeIn)
            }
        })

        mainLayout.startAnimation(fadeOut)
    }
}
