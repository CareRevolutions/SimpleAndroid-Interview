package com.carerevolutions.myapplication.feature_country_subdivision

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.carerevolutions.myapplication.feature_country_subdivision.ui_components.compose.ComposeLazyColumnForState
import com.carerevolutions.myapplication.databinding.FragmentCountrySubdivisionBinding
import com.carerevolutions.myapplication.feature_country_subdivision.ui_components.views.CountrySubdivisionAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Given the following CountrySubdivisionFragment:
 * 1. Using dagger hilt, inject the [CountrySubdivisionViewModel] dependency and call its loadCountrySubdivisionData() function.
 * 2. Using the data provided by the ViewModel implement a vertical scrollable view that will display the list of [CountrySubdivision.name].
 *    Feel free to either use compose see [ComposeForState], or views see [CountrySubdivisionAdapter].
 * 3. Bonus: Write UI tests
 */

@AndroidEntryPoint
class CountrySubdivisionFragment : Fragment() {

    private var _binding: FragmentCountrySubdivisionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountrySubdivisionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}