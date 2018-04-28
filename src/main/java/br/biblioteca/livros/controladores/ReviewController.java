package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Review;
import br.biblioteca.livros.services.ReviewService;

@Controller
@RequestMapping(ReviewController.PATH_REVIEW)
public class ReviewController {
	public static final String  PATH_REVIEW = "/review";
	public static final String PATH_REVIEW_LIST = "/reviews";
	
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping(PATH_REVIEW_LIST)
	public ModelAndView reviews() {
		List<Review> listaReviews = reviewService.listaReviews();
		return new ModelAndView("review/reviews", "reviews", listaReviews);
	}
}
