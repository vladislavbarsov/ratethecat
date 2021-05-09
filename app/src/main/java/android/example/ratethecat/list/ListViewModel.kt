package android.example.ratethecat.list

import android.example.ratethecat.network.CatApi
import android.example.ratethecat.network.CatProperty
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

enum class CatApiStatus { LOADING, ERROR, DONE}

class ListViewModel : ViewModel() {

    private val _status = MutableLiveData<CatApiStatus>()
    val status: LiveData<CatApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<CatProperty>>()
    val properties: LiveData<List<CatProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<CatProperty>()
    val navigateToSelectedProperty: LiveData<CatProperty>
        get() = _navigateToSelectedProperty

    init {
        getCatProperties()
    }

    private fun getCatProperties(){
        viewModelScope.launch {
            _status.value = CatApiStatus.LOADING
            try {
                _properties.value = CatApi.retrofitService.getProperties()
                Log.i("Response", _properties.value.toString())
                _status.value = CatApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CatApiStatus.ERROR
                Log.i("Response", _status.value.toString())
            }
        }
    }

    fun displayPropertyRating(catProperty: CatProperty) {
        _navigateToSelectedProperty.value = catProperty
        Log.i("Cat Clicked: ", catProperty.id)
    }
    fun displayPropertyRatingComplete() {
        _navigateToSelectedProperty.value = null
    }

}