package suite

import androidx.test.ext.junit.runners.AndroidJUnit4
import clientAdmin1
import org.junit.runner.RunWith
import runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test


@RunWith(AndroidJUnit4::class)
internal class TestSecuredAPIKey {

    private val test = TestSecuredAPIKeyTools()

    @BeforeTest
    fun clean() {
        runBlocking {
            cleanIndex(clientAdmin1, test.suffix)
        }
    }

    @Test
    fun expiredKey() {
        test.expiredKey()
    }

    @Test
    fun validKey() {
        test.validKey()
    }

    @Test
    fun remainingValidityParameter() {
        test.remainingValidityParameter()
    }
}