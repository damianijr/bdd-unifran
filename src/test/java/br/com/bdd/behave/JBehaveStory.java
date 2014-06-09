package br.com.bdd.behave;

import java.util.List;
import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public abstract class JBehaveStory extends JUnitStories {

	@Override
	protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), "**/" + storyFile(), "");
	}
	
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), steps());
    }
    
    @Override
    public Configuration configuration() {
        LocalizedKeywords keywords = new LocalizedKeywords(new Locale("pt"));
		return new MostUsefulConfiguration()
                .useKeywords(keywords)
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryParser(new RegexStoryParser(keywords))
                .useStoryControls(new StoryControls()
                .doDryRun(false).doSkipScenariosAfterFailure(false))
                .usePendingStepStrategy(new FailingUponPendingStep())
                .useStoryReporterBuilder(
                        new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE));
    }
	
	public abstract Object steps();

	public abstract String storyFile();

}
