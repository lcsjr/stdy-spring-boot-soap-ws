package br.com.stdy.soap.ws.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.stdy.soap.ws.CourseDetails;
import br.com.stdy.soap.ws.GetAllCourseDetailsRequest;
import br.com.stdy.soap.ws.GetAllCourseDetailsResponse;
import br.com.stdy.soap.ws.GetCourseDetailsRequest;
import br.com.stdy.soap.ws.GetCourseDetailsResponse;
import br.com.stdy.soap.ws.model.Course;
import br.com.stdy.soap.ws.model.repository.CourseDetailsRepository;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	CourseDetailsRepository repository;
	
	@PayloadRoot(namespace="http://stdy-soap.com.br/courses", localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processGetCourseDetailsRequest (@RequestPayload GetCourseDetailsRequest request) {
		Course course = repository.findById(request.getId());
	 return mapCourseDetails(course);
	}

	@PayloadRoot(namespace="http://stdy-soap.com.br/courses", localPart="GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processGetAllCourseDetailsRequest (@RequestPayload GetAllCourseDetailsRequest request) {
		return	mapAllCourseDetails(repository.findAll());
	}

	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for(Course course:courses) {
			CourseDetails mapCourse = mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}
		return response;
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(course));
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}
}
