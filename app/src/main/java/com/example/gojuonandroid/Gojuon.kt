package com.example.gojuonandroid

import android.util.Log

class Gojuon {
    val gojuonCollection : Map<Pair<String, String>,String> =
        hashMapOf(
            Pair("あ","ア" ) to "a",
            Pair("い","イ" ) to "i",
            Pair("う","ウ" ) to "u",
            Pair("え","エ" ) to "e",
            Pair("お","オ" ) to "o",
            Pair("か","カ" ) to "ka",
            Pair("き","キ" ) to "ki",
            Pair("く","ク" ) to "ku",
            Pair("け","ケ" ) to "ke",
            Pair("こ","コ" ) to "ko",
            Pair("さ","サ" ) to "sa",
            Pair("し","シ" ) to "si",
            Pair("す","ス" ) to "su",
            Pair("せ","セ" ) to "se",
            Pair("そ","ソ" ) to "so",
            Pair("た","タ" ) to "ta",
            Pair("ち","チ" ) to "chi",
            Pair("つ","ツ" ) to "tsu",
            Pair("て","テ" ) to "te",
            Pair("と","ト" ) to "to",
            Pair("は","ハ" ) to "ha",
            Pair("ひ","ヒ" ) to "hi",
            Pair("ふ","フ" ) to "fu",
            Pair("へ","ヘ" ) to "he",
            Pair("ほ","ホ" ) to "ho",
            Pair("ま","マ" ) to "ma",
            Pair("み","ミ" ) to "mi",
            Pair("む","ム" ) to "mu",
            Pair("め","メ" ) to "me",
            Pair("も","モ" ) to "mo",
            Pair("や","ヤ" ) to "ya",
            Pair("ゆ","ユ" ) to "yu",
            Pair("よ","ヨ" ) to "yo",
            Pair("ら","ラ" ) to "ra",
            Pair("り","リ" ) to "ri",
            Pair("る","ル" ) to "ru",
            Pair("れ","レ" ) to "re",
            Pair("ろ","ロ" ) to "ro",
            Pair("わ","ワ" ) to "wa",
            Pair("を","ヲ" ) to "wo",
            Pair("ん","ン" ) to "n",
            Pair("が","ガ" ) to "ga",
            Pair("ぎ","ギ" ) to "gi",
            Pair("ぐ","グ" ) to "gu",
            Pair("げ","ゲ" ) to "ge",
            Pair("ご","ゴ" ) to "go",
            Pair("ざ","ザ" ) to "za",
            Pair("じ","ジ" ) to "ji",
            Pair("ず","ズ" ) to "zu",
            Pair("ぜ","ゼ" ) to "ze",
            Pair("ぞ","ゾ" ) to "zo",
            Pair("だ","ダ" ) to "da",
            Pair("じ","ヂ" ) to "ji",
            Pair("ず","ヅ" ) to "zu",
            Pair("で","デ" ) to "de",
            Pair("ど","ド" ) to "do",
            Pair("ば","バ" ) to "ba",
            Pair("び","ビ" ) to "bi",
            Pair("ぶ","ブ" ) to "bu",
            Pair("べ","ベ" ) to "be",
            Pair("ぼ","ボ" ) to "bo",
            Pair("ぱ","パ" ) to "pa",
            Pair("ぴ","ピ" ) to "pi",
            Pair("ぷ","プ" ) to "pu",
            Pair("ぺ","ペ" ) to "pe",
            Pair("ぽ","ポ" ) to "po",
            Pair("きゃ","キャ" ) to "kya",
            Pair("きゅ","キュ" ) to "kyu",
            Pair("きょ","キョ" ) to "kyo",
            Pair("しゃ","シャ" ) to "sha",
            Pair("しゅ","シュ" ) to "shu",
            Pair("しょ","ショ" ) to "sho",
            Pair("ちゃ","チャ" ) to "cha",
            Pair("ちゅ","チュ" ) to "chu",
            Pair("ちょ","チョ" ) to "cho",
            Pair("にゃ","ニャ" ) to "nya",
            Pair("にゅ","ニュ" ) to "nyu",
            Pair("にょ","ニョ" ) to "nyo",
            Pair("ひゃ","ヒャ" ) to "hya",
            Pair("ひゅ","ヒュ" ) to "hyu",
            Pair("ひょ","ヒョ" ) to "hyo",
            Pair("みゃ","ミャ" ) to "mya",
            Pair("みゅ","ミュ" ) to "myu",
            Pair("みょ","ミョ" ) to "myo",
            Pair("りゃ","リャ" ) to "rya",
            Pair("りゅ","リュ" ) to "ryu",
            Pair("りょ","リョ" ) to "ryo",
            Pair("ぎゃ","ギャ" ) to "gya",
            Pair("ギュ","ギュ" ) to "gyu",
            Pair("ぎょ","ギョ" ) to "gyo",
            Pair("じゃ","ジャ" ) to "ja",
            Pair("じゅ","ジュ" ) to "ju",
            Pair("じょ","ジョ" ) to "jo",
            Pair("ぢゃ","ヂャ" ) to "ja",
            Pair("ぢゅ","ヂュ" ) to "ju",
            Pair("ぢょ","ヂョ" ) to "jo",
            Pair("びゃ","ビャ" ) to "bya",
            Pair("びゅ","ビュ" ) to "byu",
            Pair("びょ","ビョ" ) to "byo",
            Pair("ぴゃ","ピャ" ) to "pya",
            Pair("ぴゅ","ピュ" ) to "pyu",
            Pair("ぴょ","ピョ" ) to "pyo"
        )

    var gojuonQuestionState : MutableMap<Pair<String, String>,String> = HashMap(gojuonCollection)
    var gojuonChoiceState : MutableMap<Pair<String, String>,String> = HashMap(gojuonCollection)

    public fun pickAns(): MutableMap.MutableEntry<Pair<String, String>, String> {
        val elementPos = (0 until gojuonQuestionState.size - 1).random()
        return gojuonQuestionState.entries.elementAt(elementPos)
    }

    public fun removeAns(element : MutableMap.MutableEntry<Pair<String,String>, String>){
        gojuonQuestionState.remove(element.key)
    }

    public fun pickChoices(ans: MutableMap.MutableEntry<Pair<String,String>, String>): Map<Pair<String, String>, String>{
        var choices:  Map<Pair<String, String>,String> = HashMap<Pair<String, String>,String>()
        choices += ans!!.toPair()
        Log.w("ans" , ans.toString())

        removeChoice(ans)
        for(i in 1..2){
            val choice = pickChoice()
            choices += choice.toPair()
            removeChoice(choice)
        }
        return choices
    }

    public fun pickChoice(): MutableMap.MutableEntry<Pair<String, String>, String>{
        val elementPos = (0 until gojuonChoiceState.size - 1).random()
        return gojuonChoiceState.entries.elementAt(elementPos)
    }

    public fun removeChoice(element : MutableMap.MutableEntry<Pair<String,String>, String>){
        gojuonChoiceState.remove(element.key)
    }

    public fun resetChoice(){
        gojuonChoiceState = HashMap(gojuonCollection)
    }
}