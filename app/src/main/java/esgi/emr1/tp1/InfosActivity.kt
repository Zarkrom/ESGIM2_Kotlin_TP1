package esgi.emr1.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import esgi.emr1.tp1.databinding.ActivityInfosBinding

class InfosActivity : AppCompatActivity() {

    private lateinit var ui: ActivityInfosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infos)

        // mise en place du layout par un view binding
        ui = ActivityInfosBinding.inflate(layoutInflater)
        setContentView(ui.root)

        // titre de l'activité
        setTitle(getLocalClassName());

        ui.bouton1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                finish()
            }
        })
    }
}