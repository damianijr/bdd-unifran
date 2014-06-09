package br.com.bdd.behave;

import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.web.selenium.FirefoxWebDriverProvider;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver;

public abstract class JBehaveWebStory extends JBehaveStory {

    private FirefoxWebDriverProvider webDriverProvider;

	@Override
    public Configuration configuration() {
    	
        LocalizedKeywords keywords = new LocalizedKeywords(new Locale("pt"));
        
		webDriverProvider = new FirefoxWebDriverProvider();
		return new SeleniumConfiguration().useSeleniumContext(new SeleniumContext())
        .useWebDriverProvider(webDriverProvider)
        .useKeywords(keywords)
        // .usePendingStepStrategy(new FailingUponPendingStep())
        .useStoryParser(new RegexStoryParser(keywords))
        .useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
        .useStoryReporterBuilder(
                new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE));
    }
	
	public WebDriver getWebDriverProvider() {
		webDriverProvider.initialize();
		return webDriverProvider.get();
	}
}
