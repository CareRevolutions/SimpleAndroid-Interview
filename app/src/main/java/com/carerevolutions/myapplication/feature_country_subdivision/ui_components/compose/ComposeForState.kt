package com.carerevolutions.myapplication.feature_country_subdivision.ui_components.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.carerevolutions.myapplication.feature_country_subdivision.CountrySubdivision

@Composable
fun ComposeRowForState(stateName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {
        Text(text = stateName)
    }
}

/**
 * Pre-built composable to be used if you prefer using compose for completing this take home project.
 */
@Composable
fun ComposeLazyColumnForState(states: List<CountrySubdivision>) {
    LazyColumn(Modifier.padding(horizontal = 10.dp)) {
        items(states) { state ->
            ComposeRowForState(state.name)
            Divider()
        }
    }
}