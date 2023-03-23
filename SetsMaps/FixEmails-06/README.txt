6. Fix Emails
You are given a sequence of strings, each on a new line, until you receive the "stop" command. The first string is a name of a person. On the second line, you receive his email. Your task is to collect their names and emails and remove emails whose domain ends with "us", "uk," or "com" (case insensitive). Print in the following format:

"{name} -> {email}"

Examples:

Input 1:
John
johnDoe@softuni.org
Peter Smith
smith.peter@softuni.org
Taylor Baker
baker@gmail.com
stop

Output 1:
John -> johnDoe@softuni.org
Peter Smith -> smith.peter@softuni.org

Input 2:
Peter Adamas
peter_adams@gmail.com
Anna Foster
foster.anna@yahoo.com
Duke Jenkins
jenkins.duke@softuni.org
stop

Output 2:
Duke Jenkins -> jenkins.duke@softuni.org