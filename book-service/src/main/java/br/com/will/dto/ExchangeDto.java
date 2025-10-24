package br.com.will.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


public class ExchangeDto implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionFactor;

    private Double convertedValue;

    private String enviroment;

    public ExchangeDto() {
    }

    public ExchangeDto(Long id, String from, String to, BigDecimal conversionFactor, Double convertedValue, String enviroment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.enviroment = enviroment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeDto exchange = (ExchangeDto) o;
        return Objects.equals(id, exchange.id) && Objects.equals(from, exchange.from) && Objects.equals(to, exchange.to) && Objects.equals(conversionFactor, exchange.conversionFactor) && Objects.equals(convertedValue, exchange.convertedValue) && Objects.equals(enviroment, exchange.enviroment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, conversionFactor, convertedValue, enviroment);
    }
}
