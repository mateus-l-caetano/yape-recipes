package com.mateus.yaperecipes.ui.presentation.recipes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.mateus.yaperecipes.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeOrigin(
    latitude: Double,
    longitude: Double,
    backNavigationAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    val recipeOrigin = LatLng(latitude, longitude)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(recipeOrigin, 12f)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Recipe Origin")
                },
                navigationIcon = {
                    Icon(
                        painterResource(id = R.drawable.arrow_back),
                        "back button",
                        modifier
                            .padding(8.dp)
                            .clickable {
                                backNavigationAction()
                            }
                    )
                }
            )
        }
    ) { innerPadding ->
        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            cameraPositionState = cameraPositionState
        ) {
            AdvancedMarker(
                MarkerState(position = recipeOrigin),
                title = "Recipe origin"
            )
        }
    }
}