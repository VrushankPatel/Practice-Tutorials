In this package, i created the classes to demonstrate some Enterprise Integration Patterns based programs.

Here, these patterns can be used by driver program which is App.java in main.

Don't forget, the file in camelDemoFolder which is going to be used in these EIPs, will be deleted after consumed.
Also, don't forget to delete the queues in activeMQ dashboard before running any of these program.

The EIPs demonstrated are listed below

1> Splitter pattern : SimpleRouteBuilder.java demonstrate the splitter pattern, where we'll take data from file, split it and send it to Queue.

2> Content based routing pattern : ContentBasedRoutingPattern.java demonstrate this pattern, in which we'll use splitter and content based both.
	in this pattern, we'll send message to queue from file, take the message from queue again, check it or compare it, and then send it to crrect queue.
	before running this class, in the root of C drive, create camelDemoFolder dir, in there add file with any name and add these content to run and ensure this EIP.
	-----------------------------------
		1
		2
		3
		sampleCamel1
		data for sampleCamel3	
		sampleCamel2
		4
		3
		this might be for sampleCamel3
		kl
		fdsa
	-----------------------------------
	
3> Recipient List pattern : check RecipientListPattern.java. 
	here, we'll take the data from sampleQueue, split it, and create new queue by that name which is in the splitted data is.
	for that, we'll use process to process the data, which requires the Procecssor object, it is anonymous class, 
	so, we've to instantiate by override the process method, in that method, we'll create new queues by splitted data.
	try this data in camelDemoFolder/{anyname}.txt.
	-----------------------------------
	queue demo 1
	queue sample 2
	queue tutorial 3
	demo queue 4
	queue demo 1
	queue sample 2 
	-----------------------------------
	here, it'll create first 4 queues, duplicate queues can not be created, so, last two queue name's messages will be added to their first occurence.

4>
	