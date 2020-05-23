/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: team@openapitools.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 */


package org.openapitools.server.api

import org.openapitools.server.model.ApiResponse
import java.io.File
import org.openapitools.server.model.Pet

import java.io.File

import org.scalatra.ScalatraServlet
import org.scalatra.swagger._
import org.json4s._
import org.json4s.JsonDSL._
import org.scalatra.json.{ JValueResult, JacksonJsonSupport }
import org.scalatra.servlet.{ FileUploadSupport, MultipartConfig, SizeConstraintExceededException }

import scala.collection.JavaConverters._

class PetApi(implicit val swagger: Swagger) extends ScalatraServlet
  with FileUploadSupport
  with JacksonJsonSupport
  with SwaggerSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  protected val applicationDescription: String = "PetApi"

  before() {
    contentType = formats("json")
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }
  

  val addPetOperation = (apiOperation[Pet]("addPet")
    summary "Add a new pet to the store"
    parameters(bodyParam[Pet]("pet").description(""))
  )

  post("/pet", operation(addPetOperation)) {
    //println("pet: " + pet)
  }

  

  val deletePetOperation = (apiOperation[Unit]("deletePet")
    summary "Deletes a pet"
    parameters(pathParam[Long]("petId").description(""), headerParam[String]("apiKey").description("").optional)
  )

  delete("/pet/:petId", operation(deletePetOperation)) {
    val petId = params.getOrElse("petId", halt(400))
    //println("petId: " + petId)
    val apiKey = request.getHeader("apiKey")
    //println("apiKey: " + apiKey)
  }

  

  val findPetsByStatusOperation = (apiOperation[List[Pet]]("findPetsByStatus")
    summary "Finds Pets by status"
    parameters(queryParam[List[String]]("status").description("").defaultValue(List.empty[String] ))
  )

  get("/pet/findByStatus", operation(findPetsByStatusOperation)) {
        val statusString = params.getAs[String]("status")
    val status = if("csv" == "default" || "csv" == "csv") {
      statusString match {
        case Some(str) => str.split(",").toSeq
        case None => Seq()
      }
    } else
      Seq()

    //println("status: " + status)
  }

  

  val findPetsByTagsOperation = (apiOperation[List[Pet]]("findPetsByTags")
    summary "Finds Pets by tags"
    parameters(queryParam[List[String]]("tags").description("").defaultValue(List.empty[String] ))
  )

  get("/pet/findByTags", operation(findPetsByTagsOperation)) {
        val tagsString = params.getAs[String]("tags")
    val tags = if("csv" == "default" || "csv" == "csv") {
      tagsString match {
        case Some(str) => str.split(",").toSeq
        case None => Seq()
      }
    } else
      Seq()

    //println("tags: " + tags)
  }

  

  val getPetByIdOperation = (apiOperation[Pet]("getPetById")
    summary "Find pet by ID"
    parameters(pathParam[Long]("petId").description(""))
  )

  get("/pet/:petId", operation(getPetByIdOperation)) {
    val petId = params.getOrElse("petId", halt(400))
    //println("petId: " + petId)
  }

  

  val updatePetOperation = (apiOperation[Pet]("updatePet")
    summary "Update an existing pet"
    parameters(bodyParam[Pet]("pet").description(""))
  )

  put("/pet", operation(updatePetOperation)) {
    //println("pet: " + pet)
  }

  

  val updatePetWithFormOperation = (apiOperation[Unit]("updatePetWithForm")
    summary "Updates a pet in the store with form data"
    parameters(pathParam[Long]("petId").description(""), formParam[String]("name").description("").optional, formParam[String]("status").description("").optional)
  )

  post("/pet/:petId", operation(updatePetWithFormOperation)) {
    val petId = params.getOrElse("petId", halt(400))
    //println("petId: " + petId)
    //println("name: " + name)
    //println("status: " + status)
  }

  

  val uploadFileOperation = (apiOperation[ApiResponse]("uploadFile")
    summary "uploads an image"
    parameters(pathParam[Long]("petId").description(""), formParam[String]("additionalMetadata").description("").optional, formParam[File]("file").description("").optional)
  )

  post("/pet/:petId/uploadImage", operation(uploadFileOperation)) {
    val petId = params.getOrElse("petId", halt(400))
    //println("petId: " + petId)
    //println("additionalMetadata: " + additionalMetadata)
    val file = fileParams("file")
    //println("file: " + file)
  }

}