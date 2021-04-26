Barclays T shape project
Joshua Holloway 

jira link:
https://id.atlassian.com/invite/p/jira-software?id=xqyXiRa5T6GZpedM48Blew

Risk assessmnet link:
https://docs.google.com/spreadsheets/d/1PX21RqRny_V5-8_Y6uuwuDJYN09xrSi43_EWhSonwaw/edit?usp=sharing
Video link:




While i managed to complete the intial project, the 20 hour budged was not sustainable i easily spent 30 hours on the front end. I intially tried to just use html and javascript but between spring mvc inability to pick up anything other than the index.html, the horrendous debuging and redudancy of learning base html i ended up using a react front end. Specifically i used classed based components to render each of the functions, with the added functionality of searching by ticket status and id added to the tradition CRUD functionality. The classes would then either return to give you all the tickets or in the case of editing or inserting a ticket just the ticket that had been inserted/altered as demonstrated in the video. 

The backend had a small amount of time invested in the business logic but as im familiar with maven and basic spring it wasnt to strenous, the main problem came in understanding what was truly necessary and what was added layers and waste such as a DTO. My unfamiliarity with databases was my undoing although i successfully migrated my code from h2 and tested it with the sql database in my aws instance. The initial database setup took much longer than it should due to my unfamiliarity with database management beyond basic sql commands. 

The devops was where the project really started to get away from me while i thought i had the aws part down and functioning well when i tried to deploy jenkins i 2 days trying to get access to port 8080 to being my pipieline despite having configured everything for https http tcp udp on the network secuirtity group, eventually i solved the probelm by allowing all traffic through the security group which still makes little sense. I knew jenkins was working as when i curled from the host i recieved the html of the verification page. 
I managed to setup the pipeline on my local. The time wasted however meant i never really got much further although i got a good grasp of docker and how the pipeline is set up.
I fully tested my backend up to about 76% with junit.
