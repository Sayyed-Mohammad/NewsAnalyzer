package newsanalyzer.ctrl;

import newsapi.NewsApi;
import newsapi.beans.Article;
import newsapi.beans.NewsReponse;

import java.net.MalformedURLException;
import java.util.List;

public class Controller {

	public static final String APIKEY = "a4a1aa5ca3644801bb74367e1447c738";

	public void process(NewsApi newsApi) throws MalformedURLException, AnalyzerException {
		System.out.println("Start process");


		NewsReponse newsResponse = newsApi.getNews();
		if(newsResponse != null) {
			List<Article> articles = newsResponse.getArticles();
			articles.stream().forEach(article -> System.out.println(article.toString()));
		}
		//TODO implement Error handling

		//TODO load the news based on the parameters

		//TODO implement methods for analysis

		System.out.println("End process");
	}
	

	public Object getData() {
		
		return null;
	}
}
