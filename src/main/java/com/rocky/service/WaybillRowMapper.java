package com.rocky.service;


import com.rocky.model.Waybill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class WaybillRowMapper implements RowMapper<Waybill> {

    @Override
    public Waybill mapRow(ResultSet rs, int rowNum) throws SQLException {
        Waybill waybill = new Waybill();

        waybill.setWaybillNumber(rs.getString("waybill_number"));
        waybill.setShipmentId(rs.getString("shipment_id"));
        waybill.setContainers(Arrays.asList(rs.getString("containers").split(",")));
        waybill.setTrailers(Arrays.asList(rs.getString("trailers").split(",")));
        waybill.setIntermodal(rs.getBoolean("intermodal"));
        waybill.setInterchangePoint(rs.getString("interchange_point"));

        // Handle other fields like RouteDetails or WaybillPartyInfo, if needed

        return waybill;
    }
}
