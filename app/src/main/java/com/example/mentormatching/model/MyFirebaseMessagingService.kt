import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.mentormatching.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.Locale

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        // Tratamento baseado no tipo de notificação recebida
        remoteMessage.data["type"]?.let { type ->
            when (type) {
                "message" -> {
                    val title = remoteMessage.data["title"] ?: "Nova Mensagem!"
                    val message = remoteMessage.data["message"] ?: "Você recebeu uma nova mensagem."
                    showNotification(title, message, "message_notifications", 102)
                }
                "feedback" -> {
                    val title = remoteMessage.data["title"] ?: "Novo Feedback!"
                    val message = remoteMessage.data["message"] ?: "Você recebeu um novo feedback."
                    showNotification(title, message, "feedback_notifications", 103)
                }
            }
        }
    }

    private fun showNotification(title: String, message: String, channelId: String, notificationId: Int) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "${channelId.capitalize(Locale.ROOT)} Channel", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(getIconByType(channelId))
            .setAutoCancel(true)
            .build()

        notificationManager.notify(notificationId, notification)
    }

    private fun getIconByType(type: String): Int {
        return when (type) {
            "message_notifications" -> R.drawable.ic_message
            "feedback_notifications" -> R.drawable.ic_feedback
            else -> R.drawable.ic_notification
        }
    }
}
object NotificationMatch {
    fun sendMatchNotification(context: Context) {
        Log.d("NotificationMatch", "Preparing to send notification...")
        val title = "Novo Match!"
        val message = "Parabéns! Você tem um novo perfil compatível"
        showNotification(context, title, message, "login_notifications", 104)
    }

    private fun showNotification(context: Context, title: String, message: String, channelId: String, notificationId: Int) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
        if (notificationManager == null) {
            Log.e("NotificationHelper", "Notification Manager not available")
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelId, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
            Log.d("NotificationHelper", "Notification channel created")
        }

        val notification = NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_match)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(notificationId, notification)
        Log.d("NotificationHelper", "Notification sent")
    }
}
object NotificationHelper {
    fun sendLoginNotification(context: Context) {
        Log.d("NotificationHelper", "Preparing to send notification...")
        val title = "Bem-vindo de volta!"
        val message = "Feliz por ver você novamente."
        showNotification(context, title, message, "login_notifications", 104)
    }

    private fun showNotification(context: Context, title: String, message: String, channelId: String, notificationId: Int) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
        if (notificationManager == null) {
            Log.e("NotificationHelper", "Notification Manager not available")
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelId, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
            Log.d("NotificationHelper", "Notification channel created")
        }

        val notification = NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_login)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(notificationId, notification)
        Log.d("NotificationHelper", "Notification sent")
    }
}
