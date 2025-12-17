package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CalculoIMCTest {

    // =============================================================================================
    // TESTES DO CÁLCULO DO IMC
    // =============================================================================================

    @Test
    public void deveCalcularIMCCorretamente() {
        double imc = CalculoIMC.calcularPeso(70, 1.75);
        assertEquals(22.86, imc, 0.01);
    }

    // =============================================================================================
    // TESTES DE CLASSIFICAÇÃO (VALORES LIMITE)
    // =============================================================================================

    @Test
    public void imcAbaixoDe16DeveSerMagrezaGrave() {
        assertEquals("Magreza grave", CalculoIMC.classificarIMC(15.9));
    }

    @Test
    public void imcIgual16DeveSerMagrezaModerada() {
        assertEquals("Magreza moderada", CalculoIMC.classificarIMC(16.0));
    }


    @Test
    public void imcEntre16e17DeveSerMagrezaModerada() {
        assertEquals(
            "Magreza moderada",
            CalculoIMC.classificarIMC(16.8)
        );
    }

    @Test
    public void imcIgual17DeveSerMagrezaLeve() {
        assertEquals(
            "Magreza leve",
            CalculoIMC.classificarIMC(17.0)
        );
    }

    @Test
    public void imcEntre17e18_5DeveSerMagrezaLeve() {
        assertEquals(
            "Magreza leve",
            CalculoIMC.classificarIMC(18.4)
        );
    }

    @Test
    public void imcIgual18_5DeveSerSaudavel() {
        assertEquals(
            "Saudável",
            CalculoIMC.classificarIMC(18.5)
        );
    }

    @Test
    public void imcEntre18_5e25DeveSerSaudavel() {
        assertEquals(
            "Saudável",
            CalculoIMC.classificarIMC(24.9)
        );
    }

    @Test
    public void imcIgual25DeveSerSobrepeso() {
        assertEquals(
            "Sobrepeso",
            CalculoIMC.classificarIMC(25.0)
        );
    }

    @Test
    public void imcEntre25e30DeveSerSobrepeso() {
        assertEquals(
            "Sobrepeso",
            CalculoIMC.classificarIMC(29.9)
        );
    }

    @Test
    public void imcIgual30DeveSerObesidadeGrauI() {
        assertEquals(
            "Obesidade Grau I",
            CalculoIMC.classificarIMC(30.0)
        );
    }

    @Test
    public void imcEntre30e35DeveSerObesidadeGrauI() {
        assertEquals(
            "Obesidade Grau I",
            CalculoIMC.classificarIMC(34.9)
        );
    }

    @Test
    public void imcIgual35DeveSerObesidadeGrauII() {
        assertEquals(
            "Obesidade Grau II",
            CalculoIMC.classificarIMC(35.0)
        );
    }

    @Test
    public void imcEntre35e40DeveSerObesidadeGrauII() {
        assertEquals(
            "Obesidade Grau II",
            CalculoIMC.classificarIMC(39.9)
        );
    }

    @Test
    public void imcIgual40OuMaisDeveSerObesidadeGrauIII() {
        assertEquals(
            "Obesidade Grau III",
            CalculoIMC.classificarIMC(40.0)
        );
    }

    // =============================================================================================
    // TESTES DE ENTRADAS INVÁLIDAS
    // =============================================================================================

    @Test
    public void ERRO_pesoNegativo() {
        double imc = CalculoIMC.calcularPeso(-70, 1.75);
        assertTrue("IMC negativo é inválido", imc < 0);
    }

    @Test
    public void ERRO_alturaNegativa() {
        double imc = CalculoIMC.calcularPeso(70, -1.75);
        assertTrue("Altura negativa gera IMC inválido", imc > 0);
    }

    @Test
    public void ERRO_alturaZero() {
        double imc = CalculoIMC.calcularPeso(70, 0);
        assertTrue("Divisão por zero gera infinito", Double.isInfinite(imc));
    }

    @Test
    public void ERRO_alturaMuitoPequena() {
        double imc = CalculoIMC.calcularPeso(70, 0.01);
        assertTrue("IMC absurdo deveria ser rejeitado", imc > 1000);
    }

    @Test
    public void ERRO_nan() {
        double imc = CalculoIMC.calcularPeso(Double.NaN, 1.75);
        assertTrue("NaN propagado", Double.isNaN(imc));
    }

    @Test
    public void ERRO_infinito() {
        double imc = CalculoIMC.calcularPeso(Double.POSITIVE_INFINITY, 1.75);
        assertTrue("Infinito aceito", Double.isInfinite(imc));
    }
}
