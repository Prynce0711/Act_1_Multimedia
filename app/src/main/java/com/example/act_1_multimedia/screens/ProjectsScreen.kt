package com.example.act_1_multimedia.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Web
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Project(
    val title: String,
    val description: String,
    val technologies: List<String>,
    val icon: ImageVector,
    val projectUrl: String,
    val year: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Projects") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val projects = listOf(
                Project(
                    "Multimedia Portfolio App",
                    "A modern Android app built with Jetpack Compose showcasing my skills, projects, and experience. Features Material 3 design, smooth animations, and responsive layouts.",
                    listOf("Kotlin", "Jetpack Compose", "Material 3", "Android"),
                    Icons.Default.Android,
                    "https://github.com/Prynce0711/Act_1_Multimedia",
                    "2025"
                ),

                Project (
                    "My Portfolio",
                    "Vite",
                    listOf("Vite","Html","Css","JavaScript"),
                    Icons.Default.Web,
                    "https://github.com/Prynce0711/MyPortfolio",
                    "2025"

                ),
                Project(
                    "E-Voting System",
                    "A secure and anonymous voting system with blockchain-based verification. Includes user authentication, real-time vote counting, and result visualization.",
                    listOf("Html", "JavaScript","mySql"),
                    Icons.Default.Web,
                    "https://github.com/Prynce0711/PrynceIndiv",
                    "2024"
                ),
                Project(
                    "Adventure Quest Game",
                    "A 2D platformer game with pixel art graphics, dynamic level generation, and engaging storyline. Built using the Godot engine.",
                    listOf("GDScript", "Godot", "Pixel Art", "Game Design"),
                    Icons.Default.Games,
                    "https://github.com/yourusername/adventure-quest",
                    "2024"
                ),
                Project(
                    "Barcie International Center",
                    "A comprehensive PHP-based hotel management system for Barasoain Center for Innovative Education (BarCIE) - LCUP's Laboratory Facility for BS Tourism Management.",
                    listOf("Bootstrap", "HTML", "CSS", "JavaScript","Tailwind","Php","mySql,"),
                    Icons.Default.ShoppingCart,
                    "https://barcie.safehub-lcup.uk/",
                    "2025"

                ),


            )
            items(projects) { project ->
                ProjectCard(project)
            }
        }
    }
}

@Composable
fun ProjectCard(project: Project) {
    val uriHandler = LocalUriHandler.current
    
    ElevatedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = project.icon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = project.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = project.year,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                project.technologies.forEach { tech ->
                    AssistChip(
                        onClick = { },
                        label = { Text(tech) }
                    )
                }
            }
            
            OutlinedButton(
                onClick = { uriHandler.openUri(project.projectUrl) },
                modifier = Modifier.align(Alignment.End)
            ) {
                Icon(Icons.Default.Link, contentDescription = null)
                Spacer(modifier = Modifier.padding(5.dp))
                Text("View Project")
            }
        }
    }
}
