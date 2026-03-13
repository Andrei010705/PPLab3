import org.jsoup.Jsoup

class TreeNode(val url: String) {
    val children = mutableListOf<TreeNode>()
}

fun extrageLinkuri (urlCurent: String, domeniu: String, nivelCurent: Int, nivelMax: Int = 2): TreeNode {
    val nod = TreeNode(urlCurent)
    if (nivelCurent >= nivelMax) return nod

    try {
        val document = Jsoup.connect(urlCurent).get()
        val linkuriHTML = document.select("a[href]")
        for (link in linkuriHTML) {
            val href = link.absUrl("href")
            if (href.contains(domeniu) && href != urlCurent) {
                nod.children.add(extrageLinkuri(href, domeniu, nivelCurent + 1, nivelMax))
            }
        }
    } catch (e: Exception) {
        println("Eroare la accesarea \$urlCurent: \${e.message}")
    }
    return nod
}

fun serializeTree(node: TreeNode, indent: String = ""): String {
    var result = "\$indent\${node.url}\n"
    for (child in node.children) {
        result += serializeTree (child, "\$indent |--")
    }
    return result
}

fun main() {
    val domeniuTinta = "mike.tuiasi.ro"
    val urlStart = "http://$domeniuTinta"
    println("Începem scanarea pentru \$urlStart (aceasta poate dura câteva secunde)...")
    val rootNode = extrageLinkuri(urlStart, domeniuTinta, 0)
    val arboreSerializat = serializeTree(rootNode)
    println("\n--- Arbore Serializat ---")
    println(arboreSerializat)
}