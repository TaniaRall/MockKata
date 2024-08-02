import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.example.Copier
import org.example.IDestination
import org.example.ISource

class CopierTest {
    @MockK
    lateinit var src: ISource

    @MockK
    lateinit var dest: IDestination

    @InjectMockKs
    lateinit var copier: Copier

    @org.junit.jupiter.api.Test
    fun copy() {
        MockKAnnotations.init(this)
        every { src.ReadChar() } returns ('C')
        every { dest.WriteChar(any()) }  returns mockk()
        copier.Copy()
        verify { dest.WriteChar('C') }
    }

    @org.junit.jupiter.api.Test
    fun copyChars() {
        MockKAnnotations.init(this)
        every { src.ReadChars(any<Int>()) } answers {
            val copyCount = firstArg<Int>()
            println("copy count: $copyCount")
            val randomString = "sdhr bgvlwehv nsogvbnibv\n askjvbwib lsifbailn usecvi"
            randomString.toCharArray().copyOf(copyCount).toTypedArray()
        }
        every { dest.WriteChars(any()) }  returns mockk()
        copier.CopyChars(28)
        verify { dest.WriteChars("sdhr bgvlwehv nsogvbnibv".toCharArray().toTypedArray()) }
    }
}