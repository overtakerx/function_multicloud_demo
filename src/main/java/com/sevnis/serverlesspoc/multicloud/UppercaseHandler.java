package com.sevnis.serverlesspoc.multicloud;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import java.util.Optional;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;


public class UppercaseHandler extends AzureSpringBootRequestHandler<String, String> {

  @FunctionName("uppercase")
  public String execute(@HttpTrigger(name = "req",
      methods = {HttpMethod.GET, HttpMethod.POST},
      authLevel = AuthorizationLevel.ANONYMOUS)
      HttpRequestMessage<Optional<String>> request,
      ExecutionContext context) {

    return handleRequest(request.getBody().get(), context);
  }
}
