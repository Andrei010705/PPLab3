import org.jsoup.Jsoup

data class RssItem(val title: String, val link: String, val description: String)

data class RssFeed(
    val title: String,
    val link: String,
    val description: String,
    val items: List<RssItem>
)

fun main() {
    val url = "http://rss.cnn.com/rss/edition.rss"
    val document = Jsoup.connect(url).get()

    val channelTitle = document.select("channel > title").first().text()?: ""
    val channelLink = document.select("channel > link").first().text() ?: ""
    val channelDesc = document.select("channel > description").first()?.text()?: ""

    val itemsList = mutableListOf<RssItem>()
    val elements = document.select("item")
    for (element in elements) {
        val title = element.select("title").text()
        val link = element.select("link").text()
        val desc = element.select("description").text()
        itemsList.add(RssItem (title, link, desc))
    }

    val myFeed = RssFeed (channelTitle, channelLink, channelDesc, itemsList)

    println("Feed: \${myFeed.title}")
    println("-".repeat(50))
    for (item in myFeed.items) {
        println("Titlu: \${item.title}")
        println("Link: \${item.link}\n")
    }
}