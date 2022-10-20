package com.derich.visitkenya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.derich.visitkenya.model.DayDetails
import com.derich.visitkenya.model.DaysRepo
import com.derich.visitkenya.ui.theme.VisitKenyaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitKenyaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DaysCard(daysList = DaysRepo.daysList)
                }
            }
        }
    }
}
//a card to display all days in a vertical ordered list
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DaysCard(daysList: List<DayDetails>) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }
    Scaffold(topBar = {
        TopBar()
    }) {
AnimatedVisibility(
    visibleState = visibleState,
    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
    ), exit = fadeOut()
) {
    LazyColumn {
        itemsIndexed(daysList) {
                index, day ->
            DayDetails(
                day,
                modifier= Modifier.animateEnterExit(
                    enter = slideInVertically(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessMediumLow
                        ),
                        initialOffsetY ={it * (index + 1)}
                    )
                )
            )
        }
    }
}
}


}
//a composable card to represent a single day details
@Composable
fun DayDetails(day: DayDetails, modifier: Modifier = Modifier) {
var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 8.dp),
        elevation = 4.dp) {
        Column(modifier = modifier
            .padding(8.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            )) {
            Row {
                Text(text = stringResource(day.dayNumber),
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.weight(1f))
                ExpandableIcon(expanded = expanded,
                    onClick = { expanded = !expanded },
                    modifier = modifier.wrapContentWidth(Alignment.End))
            }
            Text(text = stringResource(day.titleOfActivity),
                style = MaterialTheme.typography.h6,
                fontStyle = FontStyle.Italic)
            if (expanded){
                MoreDetails(day = day, modifier)
            }
        }
    }
}

//composable with more details of the activity
@Composable
fun MoreDetails(day: DayDetails, modifier: Modifier = Modifier) {
    Image(painter = painterResource(day.imageOfDestination),
        contentDescription = stringResource(day.titleOfActivity),
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .padding(top = 4.dp, bottom = 4.dp),
        contentScale = ContentScale.Crop
    )
    Text(text = stringResource(day.destinationDetails),
        style = MaterialTheme.typography.caption)
}

//composable containing the top bar details
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.black_minimalist_initial_font_be_logo__2_),
            contentDescription = null,
            Modifier
                .size(60.dp)
                .clip(MaterialTheme.shapes.small)
                .padding(start = 8.dp, end = 8.dp))
        Text(text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h4, textAlign = TextAlign.Center)
    }

}
//composable for the clickable expandmore and expandless icons
@Composable
fun ExpandableIcon(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
        tint = MaterialTheme.colors.secondary,
        contentDescription = stringResource(id = R.string.expand_button_content_description))
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VisitKenyaTheme {
        DayDetails(DaysRepo.daysList[1])
    }
}

@Preview(showBackground = true)
@Composable
fun DayListLightPreview() {
    VisitKenyaTheme {
        DaysCard(daysList = DaysRepo.daysList)

    }
}

@Preview(showBackground = true)
@Composable
fun DayListDarkPreview() {
    VisitKenyaTheme( darkTheme = true) {
        DaysCard(daysList = DaysRepo.daysList)

    }
}