package com.carerevolutions.myapplication.feature_country_subdivision

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carerevolutions.myapplication.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Given the following CountrySubdivisionViewModel:
 * 1. Create a repository that will fetch data from the provided remote data source [CountrySubdivisionApi].
 * 2. Have the ViewModel observe the data emitted or produced by the repository that you created in task #1.
 * 3. With the emitted data from the repository update the [CountrySubdivisionFragment] and display the list of [CountrySubdivision.name]
 * 4. Bonus Points:
 *      - Feel free to use the tech stack you are comfortable with.. But.. Plus points if you are using the latest and greatest jetpack
 *        components (i.e. flows, coroutines, compose, etc..)
 *      - Write Unit Test for the stubbed function loadCountrySubdivisionData() [CountrySubdivisionViewModelTest]
 */

class CountrySubdivisionViewModel @Inject constructor() :
    ViewModel() {

    fun loadCountrySubdivisionData() {
        /** Fix Me.. */
    }
}