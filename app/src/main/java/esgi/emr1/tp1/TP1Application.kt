package esgi.emr1.tp1
import android.app.Application

public class TP1Application : Application() {

    private var compteur : Int = 0;

    override public fun onCreate()
    {
        super.onCreate();
        this.compteur = 0;
    }

    fun getCompteur(): Int {
        return compteur
    }

    fun setCompteur(nouveauCompteur: Int) {
        compteur = nouveauCompteur
    }

}