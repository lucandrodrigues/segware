package com.segware.upvote;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/segware/upvote/features",
        glue = {"com.segware.upvote.steps"},
        plugin = {"pretty", "html:target/report-html", "json:target/cucumber-json-report.json"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        dryRun = false
//       ,tags = {""}
)
@ActiveProfiles("teste")
public class CucumberRunner {

}