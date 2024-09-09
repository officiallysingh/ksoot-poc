package com.ksoot.poc.adapter.controller;

import com.ksoot.poc.domain.model.State;
import io.swagger.v3.oas.annotations.Operation;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.javers.core.Javers;
import org.javers.core.json.JsonConverter;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/location/")
@RequiredArgsConstructor
public class AuditController {

  private final Javers javers;

  @Operation(
      operationId = "state-snapshots",
      summary = "Get State audit logs",
      tags = {"State Management"})
  @GetMapping("/states/snapshots")
  public String getPersonSnapshots() {
    QueryBuilder jqlQuery = QueryBuilder.byClass(State.class);

    List<CdoSnapshot> changes = new ArrayList(javers.findSnapshots(jqlQuery.build()));

    changes.sort(
        (o1, o2) ->
            -1
                * o1.getCommitMetadata()
                    .getCommitDate()
                    .compareTo(o2.getCommitMetadata().getCommitDate()));

    JsonConverter jsonConverter = javers.getJsonConverter();

    return jsonConverter.toJson(changes);
  }
}
