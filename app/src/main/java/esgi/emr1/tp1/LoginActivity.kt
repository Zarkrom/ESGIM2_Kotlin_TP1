package esgi.emr1.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import esgi.emr1.tp1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var ui: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // mise en place du layout par un view binding
        ui = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(ui.root)

        // titre de l'activité
        setTitle(getLocalClassName());

        // écouteur quand on valide la saisie du pseudo
        ui.username.setOnEditorActionListener(this::onEditorAction)
    }

    private fun onEditorAction(textView: TextView?, actionId : Int, keyEvent: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            // texte saisi
            var username = ui.username.getText().toString();

            // TODO lancement de MainActivity avec username, sans retour possible

            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            intent.putExtra("USERNAME_EXTRA", username)
            startActivity(intent)
            finish()
            return true;
        } else {
            // événement non consommé
            return false;
        }
    }
}
