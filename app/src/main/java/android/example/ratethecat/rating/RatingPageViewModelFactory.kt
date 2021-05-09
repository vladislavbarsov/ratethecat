package android.example.ratethecat.rating

import android.app.Application
import android.example.ratethecat.network.CatProperty
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RatingPageViewModelFactory (
    private val catProperty: CatProperty,
    private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RatingPageViewModel::class.java)){
            return RatingPageViewModel(catProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}