package com.peter.shoestoreudacity.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peter.shoestoreudacity.models.Shoe
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShoeStoreViewModel @Inject constructor() : ViewModel() {
    private var _list = MutableLiveData<List<Shoe>>()
    val list: LiveData<List<Shoe>>
        get() = _list

    private var _selectedShoes = MutableLiveData<Shoe>()
    val selectedShoes: LiveData<Shoe>
        get() = _selectedShoes

    init {

        _list.value = listOf(
            Shoe(
                name = "Shoes 1",
                size = 40.0,
                company = "Adidas",
                description = "description of Shoes 1",
                images = listOf("https://i.pinimg.com/564x/04/09/cb/0409cb95ab4180813d327d946ccad08e.jpg")
            ),
            Shoe(
                name = "Shoes 2",
                size = 32.0,
                company = "Nike",
                description = "description of Shoes 2",
                images = listOf("https://i.pinimg.com/564x/82/78/ea/8278ea70b0cdd66bd86b6a42e4df1d33.jpg")
            ),
            Shoe(
                name = "Shoes 3",
                size = 44.0,
                company = "Nike",
                description = "description of Shoes 3",
                images = listOf("https://i.pinimg.com/564x/34/ac/5d/34ac5d982541cf8281be16cda1d09382.jpg")
            )
        )
    }

    fun setSelected(shoe: Shoe) {
        _selectedShoes.value = shoe
    }
}