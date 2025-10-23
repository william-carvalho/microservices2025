package br.com.will.services;

import br.com.will.exception.UnsuportedMathOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathServiceTest {

    private MathService mathService;

    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }

    @Test
    @DisplayName("Deve somar dois números corretamente")
    void testSum() {
        Double result = mathService.sum("10", "5");
        assertThat(result).isEqualTo(15.0);
    }

    @Test
    @DisplayName("Deve subtrair dois números corretamente")
    void testSubtraction() {
        Double result = mathService.subtraction("20", "8");
        assertThat(result).isEqualTo(12.0);
    }

    @Test
    @DisplayName("Deve multiplicar dois números corretamente")
    void testMultiplication() {
        Double result = mathService.multiplication("3", "4");
        assertThat(result).isEqualTo(12.0);
    }

    @Test
    @DisplayName("Deve dividir dois números corretamente")
    void testDivision() {
        Double result = mathService.division("10", "2");
        assertThat(result).isEqualTo(5.0);
    }

    @Test
    @DisplayName("Deve lançar exceção ao dividir por zero")
    void testDivisionByZero() {
        assertThrows(UnsuportedMathOperationException.class,
                () -> mathService.division("10", "0"));
    }

    @Test
    @DisplayName("Deve calcular média corretamente")
    void testAverage() {
        Double result = mathService.average("10", "20");
        assertThat(result).isEqualTo(15.0);
    }

    @Test
    @DisplayName("Deve calcular raiz quadrada corretamente")
    void testSquareRoot() {
        Double result = mathService.squareRoot("9");
        assertThat(result).isEqualTo(3.0);
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar raiz quadrada negativa")
    void testSquareRootNegative() {
        assertThrows(UnsuportedMathOperationException.class,
                () -> mathService.squareRoot("-9"));
    }

    @Test
    @DisplayName("Deve lançar exceção se valores não forem numéricos")
    void testInvalidNumbers() {
        assertThrows(UnsuportedMathOperationException.class,
                () -> mathService.sum("A", "10"));
    }

    @Test
    @DisplayName("Deve aceitar números com vírgula")
    void testCommaNumbers() {
        Double result = mathService.sum("10,5", "2,5");
        assertThat(result).isEqualTo(13.0);
    }
}
