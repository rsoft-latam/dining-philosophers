# Inav-web-v2

## Versions

| Angular| inav-web-v2|
| ------|:------:| 
| >=10.0.0 | v1.0.0 |
| >=9.0.0 <10.0.0 | v1.0.0 |
| >=8.0.0 <9.0.0  | v1.0.0 |
---

Table of contents
=================

  * Dynamic Page
  
## Dynamic Page
### Step 1: Import module :
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
## Child Navigation (optional)
If you want to have child routes in the panel, you have to put this in router paths

### Step 1: Routes configuration: 

To have child router in one panel we need to put it like param in the same route to the component

```shell
const routes: Routes = [
  {
    path: '', component: FatherComponent,
    children: [ { path: 'document/:childRoute', component: DocumentComponent } ]
  }
];
```

### Step 2: TS configuration: 

Now you can listen params in the router subscription, also you can save the param.childRoute to get the current child router

```shell

activatedChild : string;

constructor(private activeRoute: ActivatedRoute) {
}

this.activeRoute.params.subscribe(params => {
      this.activatedChild = parmas.childRoute;
});
```


### Step 3: HTML configuration: 

In the html file you can navigate to yours child routes like in this example

```shell
<button [routerLink]="['/document/child1']">doc1</button>
<button [routerLink]="['/document/child2']">doc2</button>
<button [routerLink]="['/document/child3']">doc2</button>

<div *ngIf = " activatedChild === 'child1' ">child1</div>
<div *ngIf =" activatedChild === 'child2' ">child2</div>
<div *ngIf = " activatedChild === 'child3' ">child3</div>
```

## API

### Inputs

| Input  | Type | Default | Required | Description |
| ------------- | ------------- | ------------- | ------------- | ------------- |
| source | `string` | `random` | yes | Set unique id for the panel |
| zindex | `string` | `random` | yes | Set z-index property for panel |
| animationTime | `number` | `600` | no | Set animation time for panel  |
| minWidth | `number` | `400` | no | Set min width for panel |
| maxWidth | `strnumbering` | `400` | no | Set max width for panel |
| preferredWidth | `number` | `400` | no | Set preferred width for panel |

### Outputs

| Output  | Description |
| ------------- | ------------- |
| (changeSize)  |  this event will work when panel changed its size |
| (animationDone)  |  this event will work when the animation for panel is completed |

## Custom styles
If you are not happy with default styles you can easily override them with increased selector specificity or creating your own theme.

```html
<dynamic-page class="panel primary"></dynamic-page>
<dynamic-page class="panel secondary"></dynamic-page>
<dynamic-page class="panel custom"></dynamic-page>
```

```css
.dynamic-page-container.custom {
  ....
}
```

If you are using bootstrap, you can use styles according to the classes xs, sm, md, lg, xl.

```css
.dynamic-page-container.xs {
  ....
}
.dynamic-page-container.sm {
  ....
}
```

