package com.strawhat.looker.chat.ui.discussions

import com.strawhat.looker.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

val discussions = listOf(
    "Supermarket", "Gas station", "Pharmacy"
)

@Composable
fun DiscussionsScreen(
    colorScheme: ColorScheme = MaterialTheme.colorScheme,
    typography: Typography = MaterialTheme.typography,
    navigateToDiscussion: () -> Unit,
) {

    DiscussionsRow(
        colorScheme = colorScheme,
        typography = typography,
        navigateToDiscussion = navigateToDiscussion,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ,
    )

}

@Composable
fun DiscussionsRow(
    colorScheme: ColorScheme,
    typography: Typography,
    navigateToDiscussion: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {

        items(3) {
            DiscussionsRowItem(
                colorScheme = colorScheme,
                typography = typography,
                navigateToDiscussion = navigateToDiscussion,
                index = it,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}

@Composable
fun DiscussionsRowItem(
    colorScheme: ColorScheme,
    typography: Typography,
    navigateToDiscussion: () -> Unit,
    index: Int,
    modifier: Modifier = Modifier,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { navigateToDiscussion() }
            .background(Color.White)
        ,
    ) {
        val id = when(index) {
            0 -> R.drawable.market
            1 -> R.drawable.gas_station
            2 -> R.drawable.pharmacy
            else -> null
        }
        if (id == null) {
            Box(
                modifier = Modifier
                    .padding(14.dp)
                    .clip(CircleShape)
                    .size(50.dp)
                    .background(colorScheme.outline)
            )
        } else {
            Image(
                painter = painterResource(id = id),
                contentDescription = discussions[index],
                modifier = Modifier
                    .padding(14.dp)
                    .clip(CircleShape)
                    .size(50.dp)
            )
        }

        Column {
            Text(
                text = discussions[index],
                color = colorScheme.onSurface,
                style = typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${discussions[index]} discussion",
                color = colorScheme.onSurfaceVariant,
                style = typography.bodyMedium
            )
        }
    }

}