package br.com.stdy.soap.ws.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.stdy.soap.ws.CourseDetails;
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
		 GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		 CourseDetails courseDetails = new CourseDetails();
		 Course course = repository.findById(request.getId());
		 
		 courseDetails.setId(course.getId());
		 courseDetails.setName(course.getName());
		 courseDetails.setDescription(course.getDescription());
		 response.setCourseDetails(courseDetails);

		 return response;
	}
}
