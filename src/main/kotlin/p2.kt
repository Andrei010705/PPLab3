fun procesareEbook (textInitial: String): String {
    var textProcesat = textInitial
    val regexSpatii = Regex("  2,}")
    val regexLiniiNoi = Regex $("\backslash n\{2,\}")$
    val regexNumarPagina = Regex("\\s+\\d+\\s+")

    textProcesat = regexSpatii.replace(textProcesat, "")
    textProcesat = regexLiniiNoi.escape(textProcesat)
    textProcesat = regexNumarPagina.replace(textProcesat, "\n")

    textProcesat = textProcesat.replace("s", "s").replace("t", "t")
    return textProcesat
}

fun main() {
    val textMurdar = "Acesta este un text cu multe spatii.\n\n\nAcesta este capitolul 2. \n 42 \nSi textul continua aici cu diacritice vechi: peştera."
    println("--- TEXT ORIGINAL ---")
    println(textMurdar)
    println("\n--- TEXT PROCESAT ---")
    println(procesareEbook(textMurdar))
}