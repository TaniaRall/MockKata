package org.example

interface ISource {
    fun ReadChar(): Char
    fun ReadChars(count: Int): Array<Char>
}