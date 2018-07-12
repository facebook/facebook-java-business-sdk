import os

flag = 0
build = os.environ['BUILD_NUMBER']

with open('pom.xml','r') as input_file, open('new_pom.xml', 'w') as output_file:
	for line in input_file.readlines():
		#print line.strip()
		if '<version>' in line and flag ==  0:
			version = line.split('</')[0].split('>')[1] + '.%s' % build
			output_file.write('  <version>%s</version>\n' % version)
			flag = 1
		else:
			output_file.write(line)

os.rename('pom.xml', 'old_pom.xml')
os.rename('new_pom.xml', 'pom.xml')