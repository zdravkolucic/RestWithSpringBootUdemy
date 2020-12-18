package de.zlucic.controller;

import de.zlucic.exception.DivisionByZeroException;
import de.zlucic.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @RequestMapping(value = "sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
            throws UnsupportedMathOperationException {
        if (isNumeric(numberOne) && isNumeric(numberTwo)) {
            double numOne = Double.parseDouble(numberOne);
            double numTwo = Double.parseDouble(numberTwo);
            return numOne + numTwo;
        } else {
            throw new UnsupportedMathOperationException("Parameter is not numeric");
        }
    }

    @RequestMapping(value = "dif/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double dif(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
            throws UnsupportedMathOperationException {
        if (isNumeric(numberOne) && isNumeric(numberTwo)) {
            double numOne = Double.parseDouble(numberOne);
            double numTwo = Double.parseDouble(numberTwo);
            return numOne - numTwo;
        } else {
            throw new UnsupportedMathOperationException("Parameter is not numeric");
        }
    }

    @RequestMapping(value = "mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mul(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
            throws UnsupportedMathOperationException {
        if( isNumeric( numberOne) && isNumeric( numberTwo)) {
            double numOne = Double.parseDouble( numberOne);
            double numTwo = Double.parseDouble( numberTwo);
            return numOne*numTwo;
        } else {
            throw new UnsupportedMathOperationException( "Parameter is not numeric");
        }
    }

    @RequestMapping( value="div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div( @PathVariable( value = "numberOne") String numberOne, @PathVariable( value="numberTwo") String numberTwo)
        throws UnsupportedMathOperationException {
        if( isNumeric( numberOne) && isNumeric( numberTwo)) {
            double numOne = Double.parseDouble( numberOne);
            double numTwo = Double.parseDouble( numberTwo);
            if ( numTwo == 0.0) {
                throw new DivisionByZeroException( "Error: Division By Zero");
            }
            return numOne / numTwo;
        } else {
            throw new UnsupportedMathOperationException( "Parameter is not numeric");
        }
    }

    @RequestMapping( value="av/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double av( @PathVariable( value = "numberOne") String numberOne, @PathVariable( value="numberTwo") String numberTwo)
            throws UnsupportedMathOperationException {
        if( isNumeric( numberOne) && isNumeric( numberTwo)) {
            double numOne = Double.parseDouble( numberOne);
            double numTwo = Double.parseDouble( numberTwo);
            return (numOne + numTwo) / 2;
        } else {
            throw new UnsupportedMathOperationException( "Parameter is not numeric");
        }
    }

    @RequestMapping( value="sqr/{number}", method = RequestMethod.GET)
    public String sqr( @PathVariable( value = "number") String number)
            throws UnsupportedMathOperationException {
        if( isNumeric( number)) {
            double num = Double.parseDouble( number);
            if (num < 0) {
                return Math.sqrt( num*(-1)) + "i";
            }
            else {
                return String.valueOf( Math.sqrt( num));
            }
        } else {
            throw new UnsupportedMathOperationException( "Parameter is not numeric");
        }
    }


    private boolean isNumeric( String string) {
        if( string == null) {
            return false;
        } else {
            string = string.replaceAll( ",", ".");
            try {
                Double.valueOf(string);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }
}
