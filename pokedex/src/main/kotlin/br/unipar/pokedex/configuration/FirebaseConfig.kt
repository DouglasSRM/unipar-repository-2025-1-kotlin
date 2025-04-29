package br.unipar.pokedex.configuration

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.FileInputStream
import java.io.InputStream

@Configuration
class FirestoreConfig {

    @Bean
    fun firestore(): Firestore {
        val servicePokemon : InputStream =
            javaClass.getResourceAsStream("/firebase-service.json")// A pasta raiz é o resources, nesse caso
                ?: throw IllegalStateException("Firebase Resource not found!")
        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .build()

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options)
        }
        return FirestoreClient.getFirestore()
    }
}