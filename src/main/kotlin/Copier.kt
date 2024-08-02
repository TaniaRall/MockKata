package org.example

class Copier(val src: ISource, val dest: IDestination) {
    fun Copy() {
        println("Copying!")
        val copiedChar = src.ReadChar()
        if(copiedChar == '\n'){
            println("Skipping copy of new line char.")
            return
        }
        dest.WriteChar(copiedChar)
    }

    fun CopyChars(count: Int) {
        val copiedChars: Array<Char> = src.ReadChars(count)
        val charsToWrite: ArrayList<Char> = arrayListOf()

         for (char in copiedChars) {
             if(char == '\n'){
                 println("Stopping copy due to new line char.")
                 break
             }

             charsToWrite.add(char)
         }

        dest.WriteChars(charsToWrite.toTypedArray())
    }
}