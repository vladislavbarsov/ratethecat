package android.example.ratethecat.rating

import android.app.Application
import android.example.ratethecat.network.CatProperty
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RatingPageViewModel (catProperty: CatProperty, app: Application) : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<CatProperty>()
    val selectedProperty: LiveData<CatProperty>
        get() = _selectedProperty

    private val _navigateBackToList = MutableLiveData<Boolean>()
    val navigateBackToList: LiveData<Boolean>
        get() = _navigateBackToList

    private val _votingRating = MutableLiveData<String>()
    val votingRating: LiveData<String>
        get() = _votingRating

    init {
        _selectedProperty.value = catProperty
        Log.i("Passed Cat", catProperty.toString())
    }

    fun onLikeClicked(){
        _votingRating.value = "1"
        Log.i("Clicked: ", "Like Button")
    }

    fun onDislikeClicked(){
        _votingRating.value = "0"
        Log.i("Clicked: ", "Dislike Button")
    }


}