# Dining Philosophers

---

Table of contents
=================

  * Dynamic Page
  
## Dynamic Page
### Step 1: Import module :
![alt text](https://firebasestorage.googleapis.com/v0/b/mi-umsa-1ca4e.appspot.com/o/book%2Fdining-philosophers.png?alt=media&token=3bdedb90-3167-4dda-85c9-d3da39b42362)

```shell
@NgModule({
  imports: [
    DynamicPageModule
  ]
})
```
### Step 2: HTML configuration:
The main component is `dynamic-page` with basic inputs source, minWidth, maxWidth and preferredWidth, also you can do reference to this panel with one local variable in this case `#panel` to get events like (close),  (changeSize), etc. Into this component you can use three components, these are optionals `<dynamic-page-header>` ,`<dynamic-page-body>` ,`<dynamic-page-footer>`
```shell
<dynamic-page   class="panel primary"
                            [source]="my-id-panel"
                            [minWidth]="300"
                            [maxWidth]="500"
                            [preferredWidth]="400"
                            #panel>
			  
    <dynamic-page-header>
    </dynamic-page-header>
	
    <dynamic-page-body>
    </dynamic-page-body>
	
	<dynamic-page-footer>
    </dynamic-page-footer>
	
</dynamic-page>

<router-outlet></router-outlet>
```

### Step 3: TS configuration : 
In the file.ts you can use event of the panel through local variable `@ViewChild('panel')`

```shell
export class DocumentComponent implements OnInit, OnDestroy {

  @ViewChild('panel') panel : any;
  
  ngOnInit(): void {
  }
  
  ngOnDestroy(): void {
  }
  
  close(): void {
    this.panel.close();
  }
  
}
```