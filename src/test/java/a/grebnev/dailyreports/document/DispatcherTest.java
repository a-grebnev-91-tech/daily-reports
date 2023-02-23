package a.grebnev.dailyreports.document;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DispatcherTest {
    @Test
    public void test1_convertNameToFio() {
        Dispatcher d = new Dispatcher(1, "Иван", "Петрович", "Сидоров");
        assertEquals(d.toString(), "Сидоров И.П.");
    }
}