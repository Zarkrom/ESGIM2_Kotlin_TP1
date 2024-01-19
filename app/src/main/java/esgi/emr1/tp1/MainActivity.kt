package esgi.emr1.tp1

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import esgi.emr1.tp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //var textView1 : TextView = findViewById(R.id.texte)

    private lateinit var ui: ActivityMainBinding

    private var compteur = 0

    private lateinit var usernameTextView: TextView

    // var app : TP1Application  =  applicationContext as TP1Application
    // var compteurGlob : Int = app.getCompteur()


    override fun onCreate(savedInstanceState: Bundle?) {
        // initialisation interne de l'activité
        super.onCreate(savedInstanceState)
        // mise en place du layout par un view binding
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
        ui.texte.text = "Voici MainActivity"

        // titre de l'activité
        title = localClassName

        // message d'information
        Log.i(TAG, "dans " + getLocalClassName() + ".onCreate");

        //textView1.text = "bonjour";

        // écouteur pour le bouton2, lambda
        ui.bouton2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                compteur += 2
                ui.texte.text = "compteur = $compteur"
            }
        })

        // écouteur pour le bouton3, référence de méthode
        ui.bouton3.setOnClickListener(this::onBouton3Click)

        // écouteur pour le bouton4, l'activité elle-même 
        ui.bouton4.setOnClickListener(this)

        ui.bouton5.setOnClickListener(this::onBouton5Click)
        ui.bouton6.setOnClickListener(this::onBouton6Click)


        usernameTextView = findViewById(R.id.texte)
        val username = intent.getStringExtra("USERNAME_EXTRA")
        if (username != null) {
            // Afficher "Bonjour" suivi du nom dans le TextView
            usernameTextView.text = "Bonjour $username"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "dans $localClassName .onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "dans $localClassName .onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "dans $localClassName .onResume")
    }


    public fun onBouton1Click(view: View) {
        compteur += 1
        ui.texte.text = "compteur =  $compteur"
    }

    private fun onBouton3Click(view: View?) {
        compteur *= 2
        ui.texte.text = "compteur = $compteur"
    }

    private fun onBouton5Click(view: View) {
        val intent = Intent(this@MainActivity, InfosActivity::class.java)
        startActivity(intent)
    }

    private fun onBouton6Click(view: View) {
        val intent = Intent(this@MainActivity, InfosActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onClick(view: View) {
        compteur *= 5;
        ui.texte.text = "compteur =  $compteur "
    }
}
