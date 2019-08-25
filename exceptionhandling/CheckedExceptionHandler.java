package com.lsr.exceptionhandling;

import com.lsr.model.ErrorResponseVO;
import com.lsr.model.ErrorVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CheckedExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BusinessServiceException.class)
  @ResponseBody
  public ResponseEntity<ErrorResponseVO> handleBusinessServiceException(
      final BusinessServiceException businessServiceException) {
    ErrorResponseVO errorResponse = buildErrorResponse(
        businessServiceException.getMessage(), "Business validation fails",
        HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
    return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
  }


  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseBody
  public ResponseEntity<ErrorResponseVO> handleIllegalArgumentException(
      final BusinessServiceException businessServiceException) {
    ErrorResponseVO errorResponse = buildErrorResponse(
        businessServiceException.getMessage(), "Invalid Credential",
        HttpStatus.UNAUTHORIZED.getReasonPhrase());
    return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
  }

  private ErrorResponseVO buildErrorResponse(String errorCode, String errorMessage,
      String httpStatusCode) {
    ErrorResponseVO errorResponse = new ErrorResponseVO();
    List<ErrorVO> errors = new ArrayList<>();
    ErrorVO error = new ErrorVO();
    errorResponse.setHttpStatusCode(httpStatusCode);
    error.setErrorCode(errorCode);
    error.setErrorMessage(errorMessage);
    error.setErrorType("Business validate issue");
    errors.add(error);
    errorResponse.setErrors(errors);
    return errorResponse;
  }
}
