package com.thoughtworks.basic;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArgTest {

	@Test
	public void l_schema_value_error_test() {
		//given
		Arg arg = new Arg();
		List<Schema> schemas = new ArrayList<Schema>();
		SchemaL schemaL = new SchemaL();
		schemaL.setValue("true1");
		schemas.add(schemaL);

		//when
		try {
			arg.arg(schemas);
			//then
			fail(CodeValueContant.SCHEMA_L + "schema值类型错误");
		} catch (Exception e) {
			//then
			assertTrue(e instanceof SchemaException);
		}                       
	}

	@Test
	public void l_schema_repeat_error_test() {
		//given
		Arg arg = new Arg();
		List<Schema> schemas = new ArrayList<Schema>();
		SchemaL schemaL1 = new SchemaL();
		schemaL1.setValue("true");
		SchemaL schemaL2 = new SchemaL();
		schemaL2.setValue("false");
		schemas.add(schemaL1);
		schemas.add(schemaL2);
		//when
		try {
			arg.arg(schemas);
			//then
			fail(CodeValueContant.SCHEMA_L + "schema重复");
		} catch (Exception e) {
			//then
			assertTrue(e instanceof SchemaException);
		}
	}

	@Test
	public void p_schema_value_error_test() {
		//given
		Arg arg = new Arg();
		List<Schema> schemas = new ArrayList<Schema>();
		SchemaP schemaP = new SchemaP();
		schemaP.setValue("1.2");
		schemas.add(schemaP);

		//when
		try {
			arg.arg(schemas);
			//then
			fail(CodeValueContant.SCHEMA_P + "schema值类型错误");
		} catch (Exception e) {
			//then
			assertTrue(e instanceof SchemaException);
		}                       
	}

	@Test
	public void p_schema_repeat_error_test() {
		//given
		Arg arg = new Arg();
		List<Schema> schemas = new ArrayList<Schema>();
		SchemaP SchemaP1 = new SchemaP();
		SchemaP1.setValue("8080");
		SchemaP SchemaP2 = new SchemaP();
		SchemaP2.setValue("8181");
		schemas.add(SchemaP1);
		schemas.add(SchemaP2);
		//when
		try {
			arg.arg(schemas);
			//then
			fail(CodeValueContant.SCHEMA_P + "schema重复");
		} catch (Exception e) {
			//then
			assertTrue(e instanceof SchemaException);
		}
	}

	@Test
	public void unkown_schema_value_error_test() {
		//given
		Arg arg = new Arg();
		List<Schema> schemas = new ArrayList<Schema>();
		SchemaUnkown schemaUnkown = new SchemaUnkown();
		schemaUnkown.setValue("schemaUnkown");
		schemas.add(schemaUnkown);

		//when
		try {
			arg.arg(schemas);
			//then
			fail("存在未知schema，请核实");
		} catch (Exception e) {
			//then
			assertTrue(e instanceof SchemaException);
		}                       
	}

	@Test
	public void d_schema_repeat_error_test() {
		//given
		Arg arg = new Arg();
		List<Schema> schemas = new ArrayList<Schema>();
		SchemaD schemaD1 = new SchemaD();
		schemaD1.setValue("/ASP");
		SchemaD schemaD2 = new SchemaD();
		schemaD2.setValue("/USC");
		schemas.add(schemaD1);
		schemas.add(schemaD2);
		//when
		try {
			arg.arg(schemas);
			//then
			fail(CodeValueContant.SCHEMA_D + "schema重复");
		} catch (Exception e) {
			//then
			assertTrue(e instanceof SchemaException);
		}
	}				 
}
