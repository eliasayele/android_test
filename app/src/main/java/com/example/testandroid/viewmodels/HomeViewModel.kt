package com.example.testandroid.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.testandroid.models.Categories
import com.example.testandroid.models.getCategory

class HomeViewModel(): ViewModel() {
    val selectedCategory: MutableState<Categories?> = mutableStateOf(null)

    val isFistItemSelected:MutableState<Boolean> = mutableStateOf(true)

    fun onSelectedCategoryChanged(category: String){
        val newCategory = getCategory(category)
        selectedCategory.value = newCategory
    }

    fun onUnselectedFirstItem(){
        isFistItemSelected.value = false
    }
}